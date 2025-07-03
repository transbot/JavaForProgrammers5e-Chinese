// 8.7节, 生成式AI练习: Time1.java
// 重构图8.10的代码，使用24小时制维护时间（基于总秒数实现）

public class Time1 {
    private int totalSeconds; // 从午夜开始的总秒数 (0~86399)

    // 使用世界时设置新时间值；如果时、分或秒无效则抛出异常
    public void setTime(int hour, int minute, int second) {
        // 验证时、分、秒的有效性
        if (hour < 0 || hour >= 24 || minute < 0 || minute >= 60 || 
            second < 0 || second >= 60) {
            throw new IllegalArgumentException("小时、分钟和/或秒超出范围");
        }
        
        // 计算并存储总秒数
        totalSeconds = hour * 3600 + minute * 60 + second;
    }

    // 转换为世界时间格式字符串（HH:MM:SS）
    public String toUniversalString() {
        int hour = totalSeconds / 3600;
        int minute = (totalSeconds % 3600) / 60;
        int second = totalSeconds % 60;
        return String.format("%02d:%02d:%02d", hour, minute, second);
    }

    // 转换为标准时间格式字符串（H:MM:SS AM 或 PM）
    public String toString() {
        int hour = totalSeconds / 3600;
        int minute = (totalSeconds % 3600) / 60;
        int second = totalSeconds % 60;
        
        return String.format("%d:%02d:%02d %s", 
            ((hour == 0 || hour == 12) ? 12 : hour % 12),
            minute, second, (hour < 12 ? "AM" : "PM"));
    }
}