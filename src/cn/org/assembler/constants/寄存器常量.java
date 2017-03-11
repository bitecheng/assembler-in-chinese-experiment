package cn.org.assembler.constants;

import java.util.HashMap;

public class 寄存器常量 {
  public static final String 四字节累加寄存器名 = "RAX";
  public static final HashMap<String, Integer> 四字节寄存器对应码 = new HashMap<>();
  
  // Table 3-1, Intel® 64 and IA-32 architectures software developer’s manual combined volumes
  static {
    四字节寄存器对应码.put(四字节累加寄存器名, 0);
  }
}
