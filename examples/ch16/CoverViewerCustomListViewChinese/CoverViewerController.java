// CoverViewerController.java
// “封面查看器”应用程序的控制器
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import java.awt.Desktop;
import java.net.URI;
import javafx.scene.Cursor;

public class CoverViewerController {
    // 用于与GUI组件交互的实例变量
    @FXML private ListView<Book> booksListView;
    @FXML private ImageView coverImageView;
    
    // 存储当前选中的书籍
    private Book selectedBook;

    // 存储Book对象列表
    private final ObservableList<Book> books = 
        FXCollections.observableArrayList();

    // 初始化控制器
    public void initialize() {
        // 填充ObservableList<Book>，添加URL示例
        books.add(new Book("Visual C#从入门到精通", 
            "/images/small/vcsharp.jpg", "/images/large/vcsharp.jpg",
            "https://bookzhou.com/2022/12/14/548/"));
        books.add(new Book("学习C++20中文版",
            "/images/small/cpp20.jpg", "/images/large/cpp20.jpg",
            "https://bookzhou.com/2023/07/07/619/"));
        books.add(new Book("CLR via C#",  
            "/images/small/clrviacsharp.jpg", "/images/large/clrviacsharp.jpg",
            "https://bookzhou.com/2024/10/07/1667/"));
        books.add(new Book("机器学习与人工智能实战",  
            "/images/small/appliedML.jpg", "/images/large/appliedML.jpg",
            "https://bookzhou.com/2023/08/20/638/"));
        books.add(new Book("Windows核心编程", 
            "/images/small/windowsviacpp.jpg", "/images/large/windowsviacpp.jpg",
            "https://bookzhou.com/2022/12/14/536/"));
        books.add(new Book("C# 12.0本质论", 
            "/images/small/EssentialCSharp.jpg", "/images/large/EssentialCSharp.jpg",
            "https://bookzhou.com/2024/10/07/1683/"));
        books.add(new Book("高质量需求", 
            "/images/small/SRE.jpg", "/images/large/SRE.jpg",
            "https://bookzhou.com/2025/04/15/3297/"));
        books.add(new Book("大模型编程实践与提示工程", 
            "/images/small/ProgrammingLLM.jpg", "/images/large/ProgrammingLLM.jpg",
            "https://bookzhou.com/2024/12/30/2149/"));
            
        booksListView.setItems(books); // 将booksListView绑定到books

        // 当ListView中的选择发生改变时，在ImageView中显示封面大图
        booksListView.getSelectionModel().selectedItemProperty().
            addListener(
                (ov, oldValue, newValue) -> {    
                    selectedBook = newValue;                    
                    coverImageView.setImage(
                        new Image(newValue.largeImage()));
                }
            );                                                                  

        // 设置自定义 ListView单元格工厂
        booksListView.setCellFactory(
            listView -> new ImageTextCell()
        );   
        
        // 为封面图片添加点击事件
        coverImageView.setOnMouseClicked(event -> {
            if (selectedBook != null && Desktop.isDesktopSupported()) {
                try {
                    Desktop.getDesktop().browse(new URI(selectedBook.url()));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        // 设置大图的鼠标悬停光标为手形
        coverImageView.setCursor(Cursor.HAND);
    }     
}