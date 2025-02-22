package designPattern.observerPattern.entity;

import java.time.LocalDateTime;

/**
 * 彩票实体类
 */
public class Lottery {

    /*
    生产日期
     */
    private LocalDateTime productionTime = LocalDateTime.now();

    /*
    彩票号码
     */
    private String msg;


    public LocalDateTime getProductionTime() {
        return productionTime;
    }

    public void setProductionTime(LocalDateTime productionTime) {
        this.productionTime = productionTime;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
