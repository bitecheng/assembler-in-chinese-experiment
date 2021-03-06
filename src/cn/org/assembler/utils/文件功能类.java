package cn.org.assembler.utils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 文件功能类 {

  /**
   * 返回文件中的所有行
   * @param 文件名
   * @return
   */
  public static List<String> 读取行(String 文件名) {
    List<String> 行 = new ArrayList<>();
    File 文件 = new File(文件名);
    if (!文件.exists()) {
      return new ArrayList<>();
    }
    try (Scanner 扫描器 = new Scanner(文件)) {

      while (扫描器.hasNext()) {
        行.add(扫描器.nextLine());
      }

    } catch (IOException e) {
      e.printStackTrace();
    }
    return 行;
  }
}
