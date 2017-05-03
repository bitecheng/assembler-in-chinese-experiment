package cn.org.assembler.模型;

import static org.junit.Assert.*;

import org.junit.Test;

import cn.org.assembler.模型.代码行类.操作数类型;

public class 操作数信息测试类 {

  @Test
  public void 取操作数信息() {
    assertEquals(new 操作数信息类(操作数类型.寄存器, 8, "AL"), 操作数信息类.取操作数信息("al"));
    assertEquals(new 操作数信息类(操作数类型.寄存器, 16, "AX"), 操作数信息类.取操作数信息("ax"));
    assertEquals(new 操作数信息类(操作数类型.寄存器, 64, "RAX"), 操作数信息类.取操作数信息("rax"));
    assertEquals(new 操作数信息类(操作数类型.寄存器, 8, "AL"), 操作数信息类.取操作数信息("byte al"));
    assertEquals(new 操作数信息类(操作数类型.立即数, 8, "0"), 操作数信息类.取操作数信息("0"));
    assertEquals(new 操作数信息类(操作数类型.立即数, 8, "127"), 操作数信息类.取操作数信息("strict byte 0x7f"));
    assertEquals(new 操作数信息类(操作数类型.立即数, 8, "1"), 操作数信息类.取操作数信息("1h"));
    assertEquals(new 操作数信息类(操作数类型.立即数, 32, "35"), 操作数信息类.取操作数信息("strict dword 35"));
    assertEquals(new 操作数信息类(操作数类型.立即数, 16, "128"), 操作数信息类.取操作数信息("0x80"));
    assertEquals(new 操作数信息类(操作数类型.立即数, 64, "1234605616436508552"), 操作数信息类.取操作数信息("0x1122334455667788"));
    assertEquals(new 操作数信息类(操作数类型.内存, 0, "0"), 操作数信息类.取操作数信息("[0]"));
    assertEquals(new 操作数信息类(操作数类型.内存, 8, "0"), 操作数信息类.取操作数信息("byte [0]"));
    assertEquals(new 操作数信息类(操作数类型.内存, 32, "0"), 操作数信息类.取操作数信息("dword [0]"));
  }

}
