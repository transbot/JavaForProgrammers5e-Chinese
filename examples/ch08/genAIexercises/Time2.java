// 8.10节, 生成式AI练习: Time2.java
// 重构图8.14的代码，使用24小时制维护时间（基于总秒数实现）

public class Time2 {
    private int totalSeconds; // 从午夜开始的总秒数 (0~86399)

    // Time2的无参构造函数：
    // 将时间初始化为午夜(00:00:00)
    public Time2() {
        this(0, 0, 0); // 委托给三参数构造函数
    }

    // Time2构造函数：提供小时，分钟和秒默认为0
    public Time2(int hour) {
        this(hour, 0, 0); // 委托给三参数构造函数
    }

    // Time2构造函数：提供小时和分钟，秒默认为0
    public Time2(int hour, int minute) {
        this(hour, minute, 0); // 委托给三参数构造函数
    }

    // Time2构造函数：提供小时、分钟和秒
    public Time2(int hour, int minute, int second) {
        setTime(hour, minute, second); // 复用setTime的验证逻辑
    }

    // Time2构造函数：提供另一个Time2对象
    public Time2(Time2 time) {
        this.totalSeconds = time.totalSeconds; // 直接复制总秒数
    }

    // 赋值方法（setter）
    // 使用世界时间设置新时间值
    // 校验数据有效性
    public void setTime(int hour, int minute, int second) {
        // 验证时、分、秒的有效性
        if (hour < 0 || hour >= 24) {
            throw new IllegalArgumentException("小时必须是0~23");
        }
        if (minute < 0 || minute >= 60) {
            throw new IllegalArgumentException("分钟必须是0~59");
        }
        if (second < 0 || second >= 60) {
            throw new IllegalArgumentException("秒必须是0~59");
        }
        
        // 计算并存储总秒数
        this.totalSeconds = hour * 3600 + minute * 60 + second;
    }

    // 校验并设置小时
    public void setHour(int hour) {
        if (hour < 0 || hour >= 24) {
            throw new IllegalArgumentException("小时必须是0~23");
        }
        
        // 保留当前分钟和秒，只更新小时
        int currentMinute = getMinute();
        int currentSecond = getSecond();
        this.totalSeconds = hour * 3600 + currentMinute * 60 + currentSecond;
    }

    // 校验并设置分钟
    public void setMinute(int minute) {
        if (minute < 0 || minute >= 60) {
            throw new IllegalArgumentException("分钟必须是0~59");
        }
        
        // 保留当前小时和秒，只更新分钟
        int currentHour = getHour();
        int currentSecond = getSecond();
        this.totalSeconds = currentHour * 3600 + minute * 60 + currentSecond;
    }

    // 校验并设置秒
    public void setSecond(int second) {
        if (second < 0 || second >= 60) {
            throw new IllegalArgumentException("秒必须是0~59");
        }
        
        // 保留当前小时和分钟，只更新秒
        int currentHour = getHour();
        int currentMinute = getMinute();
        this.totalSeconds = currentHour * 3600 + currentMinute * 60 + second;
    }

    // 取值方法（getter）
    // 获取小时值
    public int getHour() {
        return totalSeconds / 3600;
    }

    // 获取分钟值
    public int getMinute() {
        return (totalSeconds % 3600) / 60;
    }

    // 获取秒值
    public int getSecond() {
        return totalSeconds % 60;
    }

    // 转换为世界时间格式字符串 (HH:MM:SS)
    public String toUniversalString() {
        return String.format("%02d:%02d:%02d", 
            getHour(), getMinute(), getSecond());
    }

    // 转换为标准时间格式字符串 (H:MM:SS AM 或 PM)
    public String toString() {
        int hour = getHour();
        return String.format("%d:%02d:%02d %s", 
            ((hour == 0 || hour == 12) ? 12 : hour % 12),
            getMinute(), getSecond(), (hour < 12 ? "AM" : "PM"));
    }
}