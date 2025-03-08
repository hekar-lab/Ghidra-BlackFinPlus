package blackfinplus;

import ghidra.program.model.lang.ParallelInstructionLanguageHelper;
import ghidra.program.model.listing.Instruction;

public class BlackFinPlusParallelInstrHelper implements ParallelInstructionLanguageHelper {
	@Override
	public String getMnemonicPrefix(Instruction instr) {
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