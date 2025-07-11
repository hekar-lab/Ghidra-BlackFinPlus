package ghidra.app.util.bin.format.elf.relocation;

import ghidra.app.util.bin.format.elf.ElfConstants;
import ghidra.app.util.bin.format.elf.ElfHeader;
import ghidra.app.util.bin.format.elf.ElfRelocation;
import ghidra.app.util.bin.format.elf.ElfSymbol;
import ghidra.program.model.address.Address;
import ghidra.program.model.listing.Program;
import ghidra.program.model.mem.Memory;
import ghidra.program.model.mem.MemoryAccessException;
import ghidra.program.model.reloc.Relocation.Status;
import ghidra.program.model.reloc.RelocationResult;

public class Blackfin_ElfRelocationHandler 
	extends AbstractElfRelocationHandler<Blackfin_ElfRelocationType, ElfRelocationContext<?>> {

	public Blackfin_ElfRelocationHandler() {
		super(Blackfin_ElfRelocationType.class);
	}

	@Override
	public boolean canRelocate(ElfHeader elf) {
		return elf.e_machine() == ElfConstants.EM_BLACKFIN;
	}

	@Override
	protected RelocationResult relocate(
		ElfRelocationContext<?> elfRelocCtx, ElfRelocation elfReloc, Blackfin_ElfRelocationType elfRelocType,
		Address relocAddr, ElfSymbol elfSymb, Address symbAddr, long symbVal, String SymbName
	) throws MemoryAccessException {
		ElfHeader elf = elfRelocCtx.getElfHeader();
		if (!canRelocate(elf)) {
			return RelocationResult.FAILURE;
		}

		Program program = elfRelocCtx.getProgram();
		Memory memory = program.getMemory();

		int byteLength = 4;

		switch (elfRelocType) {
			case R_BFIN_FUNCDESC:
				memory.setInt(relocAddr, (int)symbVal);
				break;
			case R_BFIN_FUNCDESC_VALUE:
				memory.setInt(relocAddr, (int)symbVal);
				memory.setInt(relocAddr.add(4), 0);
				byteLength = 8;
				break;
			default:
				markAsUnhandled(program, relocAddr, elfRelocType, byteLength, SymbName, elfRelocCtx.getLog());
				return RelocationResult.UNSUPPORTED;
		}

		return new RelocationResult(Status.APPLIED, byteLength);
	}

}