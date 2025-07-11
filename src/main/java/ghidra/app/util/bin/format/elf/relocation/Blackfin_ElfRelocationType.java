package ghidra.app.util.bin.format.elf.relocation;

public enum Blackfin_ElfRelocationType implements ElfRelocationType {
    R_BFIN_UNUSED0(0x0),
	R_BFIN_PCREL5M2(0x01),
	R_BFIN_UNUSED1(0x02), // Not defined/used
	R_BFIN_PCREL10(0x03),
	R_BFIN_PCREL12_JUMP(0x04),
	R_BFIN_RIMM16(0x05),
	R_BFIN_LUIMM16(0x06),
	R_BFIN_HUIMM16(0x07),
	R_BFIN_PCREL12_JUMP_S(0x08),
	R_BFIN_PCREL24_JUMP_X(0x09),
	R_BFIN_PCREL24(0x0a),
	R_BFIN_UNUSEDB(0x0b), // Not defined/used
	R_BFIN_UNUSEDC(0x0c), // Not defined/used
	R_BFIN_PCREL24_JUMP_L(0x0d),
	R_BFIN_PCREL24_CALL_X(0x0e),
	R_BFIN_VAR_EQ_SYMB(0x0f),
	R_BFIN_BYTE_DATA(0x10),
	R_BFIN_BYTE2_DATA(0x11),
	R_BFIN_BYTE4_DATA(0x12),
	R_BFIN_PCREL11(0x13),
	R_BFIN_GOT17M4(0x14),
	R_BFIN_GOTHI(0x15),
	R_BFIN_GOTLO(0x16),
	R_BFIN_FUNCDESC(0x17),
	R_BFIN_FUNCDESC_GOT17M4(0x18),
	R_BFIN_FUNCDESC_GOTHI(0x19),
	R_BFIN_FUNCDESC_GOTLO(0x1a),
	R_BFIN_FUNCDESC_VALUE(0x1b),
	R_BFIN_FUNCDESC_GOTOFF17M4(0x1c),
	R_BFIN_FUNCDESC_GOTOFFHI(0x1d),
	R_BFIN_FUNCDESC_GOTOFFLO(0x1e),
	R_BFIN_GOTOFF17M4(0x1f),
	R_BFIN_GOTOFFHI(0x20),
	R_BFIN_GOTOFFLO(0x21),

	R_BFIN_PUSH(0xE0),
	R_BFIN_CONST(0xE1),
	R_BFIN_ADD(0xE2),
	R_BFIN_SUB(0xE3),
	R_BFIN_MULT(0xE4),
	R_BFIN_DIV(0xE5),
	R_BFIN_MOD(0xE6),
	R_BFIN_LSHIFT(0xE7),
	R_BFIN_RSHIFT(0xE8),
	R_BFIN_AND(0xE9),
	R_BFIN_OR(0xEA),
	R_BFIN_XOR(0xEB),
	R_BFIN_LAND(0xEC),
	R_BFIN_LOR(0xED),
	R_BFIN_LEN(0xEE),
	R_BFIN_NEG(0xEF),
	R_BFIN_COMP(0xF0),
	R_BFIN_PAGE(0xF1),
	R_BFIN_HWPAGE(0xF2),
	R_BFIN_ADDR(0xF3),
	
	R_BFIN_PLTPC(0x40),         /* PLT gnu only relocation */
	R_BFIN_GOT(0x41),           /* GOT gnu only relocation */
	R_BFIN_GNU_VTINHERIT(0x42), /* C++ = gnu only */
	R_BFIN_GNU_VTENTRY(0x43);   /* C++ = gnu only */

    public final int typeId;

	private Blackfin_ElfRelocationType(int typeId) {
		this.typeId = typeId;
	}

	@Override
	public int typeId() {
		return typeId;
	}
}
