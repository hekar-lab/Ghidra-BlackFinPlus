package blackfinplus;

import ghidra.program.model.lang.ParallelInstructionLanguageHelper;
import ghidra.program.model.listing.Instruction;

public class BlackfinPlusParallelInstrHelper implements ParallelInstructionLanguageHelper {
	private boolean isMulti(Instruction instr) throws Exception {
		byte[] raw = instr.getParsedBytes();
		return ((raw[1] & 0xf8) ^ 0xc8) == 0x00;
	}

	@Override
	public String getMnemonicPrefix(Instruction instr) {
		try {
			Instruction prev = instr.getPrevious();
			Instruction prev2 = prev.getPrevious();

			if (isMulti(prev) || isMulti(prev2)) {
				return "||";
			}
		} catch(Exception e) {
			return null;
		}
		
		return null;
	}

	@Override
	public boolean isParallelInstruction(Instruction instruction) {
		// It seems like this method is unused in Ghidra codebase.
		// Which, if true, pretty much foils our plans to use it to implement parallel instructions. 
		return false;
	}

	@Override
	public boolean isEndOfParallelInstructionGroup(Instruction instruction) {
		return false;
	}
}