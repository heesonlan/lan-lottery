package com.lan.lottery.vo;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.write.style.ColumnWidth;
import com.alibaba.excel.annotation.write.style.ContentRowHeight;
import com.alibaba.excel.annotation.write.style.HeadRowHeight;
import lombok.Data;

@Data
@ColumnWidth(25)
@HeadRowHeight(40)
@ContentRowHeight(18)
public class LotteryWinnerExportVo {

    @ColumnWidth(20)
    @ExcelProperty(value = "奖项", index = 0)
    private String awards;
    @ColumnWidth(30)
    @ExcelProperty(value = "奖品", index = 1)
    private String prize;

    @ColumnWidth(20)
    @ExcelProperty(value = "邮箱前缀", index = 2)
    private String userName;
    @ColumnWidth(20)
    @ExcelProperty(value = "姓名", index = 3)
    private String realName;
    @ColumnWidth(20)
    @ExcelProperty(value = "工号", index = 4)
    private String workNo;
    @ColumnWidth(20)
    @ExcelProperty(value = "城市", index = 5)
    private String city;
    @ColumnWidth(20)
    @ExcelProperty(value = "O3", index = 6)
    private String o3;
    @ColumnWidth(20)
    @ExcelProperty(value = "O4", index = 7)
    private String o4;
    @ColumnWidth(20)
    @ExcelProperty(value = "O5", index = 8)
    private String o5;

}
