package cn.org.assembler.utils;

import java.util.Objects;

import cn.org.assembler.constants.寄存器常量;

public class 操作数元数据类 {

  public static final 操作数元数据类 寄存器 = new 操作数元数据类();
  public static final 操作数元数据类 寄存器64 = new 操作数元数据类();
  public static final 操作数元数据类 立即数64 = new 操作数元数据类();
  public static final 操作数元数据类 立即数32 = new 操作数元数据类();
  public static final 操作数元数据类 不确定 = new 操作数元数据类();

  public static final String 类型16_32 = "vds";
  public static final String 类型16_32_64 = "vqp";

  public static final String 寻址方式_寄存器_ModRM = "E";
  public static final String 寻址方式_寄存器 = "Z";
  public static final String 寻址方式_立即数 = "I";
  
  static {
    寄存器.寻址方式 = 寻址方式_寄存器;

    立即数32.寻址方式 = 寻址方式_立即数;
    立即数32.类型 = 类型16_32;

    立即数64.寻址方式 = 寻址方式_立即数;
    立即数64.类型 = 类型16_32_64;

    寄存器64.寻址方式 = 寻址方式_寄存器;
    寄存器64.类型 = 类型16_32_64;
  }

  public boolean 为源;

  // TODO: 改为ENUM
  public String 类型; // 16/32/64
  public String 寻址方式;

  public String 显式名称;

  public int 取立即数位数() {
    return 类型.equals(类型16_32) ? 32 : 64;
  }

  // TODO: 仅作演示用. 需更精细的模式匹配
  public static 操作数元数据类 取操作数类型(String 操作数) {
    if (操作数.startsWith("0x")) {
      // 若十六进制数字部分超过8位字符长度, 为64位数
      return 操作数.length() > 2 + 8 ? 立即数64 : 立即数32;
    } else {
      if (寄存器常量.为四字节寄存器(操作数)) {
        return 寄存器64;
      }
      if (寄存器常量.取寄存器码(操作数) != null) {
        return 寄存器;
      }
    }
    return 不确定;
  }

  @Override
  public boolean equals(Object 对象) {
    return 对象 instanceof 操作数元数据类 && Objects.equals(类型, ((操作数元数据类) 对象).类型)
        && Objects.equals(寻址方式, ((操作数元数据类) 对象).寻址方式);
  }

}
