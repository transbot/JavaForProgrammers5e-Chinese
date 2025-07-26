// 图17.18: ThreeDimensionalShapesController.java
// 设置在3D形状上显示的材质
import javafx.fxml.FXML;
import javafx.scene.paint.Color;
import javafx.scene.paint.PhongMaterial;
import javafx.scene.image.Image;
import javafx.scene.shape.Box;
import javafx.scene.shape.Cylinder;
import javafx.scene.shape.Sphere;

public class ThreeDimensionalShapesController {
   // 引用了3D形状的实例变量
   @FXML private Box box;       
   @FXML private Cylinder cylinder;       
   @FXML private Sphere sphere;       

   // 为每个3D形状设置材质
   @FXML
   public void initialize() {
      // 为Box对象定义材质
      var boxMaterial = new PhongMaterial();
      boxMaterial.setDiffuseColor(Color.CYAN);      
      box.setMaterial(boxMaterial);

      // 为Cylinder对象定义材质
      var cylinderMaterial = new PhongMaterial();
      cylinderMaterial.setDiffuseMap(new Image("yellowflowers.png"));      
      cylinder.setMaterial(cylinderMaterial);

      // 为Sphere对象定义材质
      var sphereMaterial = new PhongMaterial();
      sphereMaterial.setDiffuseColor(Color.RED);      
      sphereMaterial.setSpecularColor(Color.WHITE);      
      sphereMaterial.setSpecularPower(32);      
      sphere.setMaterial(sphereMaterial);
   }
}

/**************************************************************************
 * (C) Copyright 1992-2025 by Deitel & Associates, Inc. and               *
 * Pearson Education, Inc. All Rights Reserved.                           *
 *                                                                        *
 * DISCLAIMER: The authors and publisher of this book have used their     *
 * best efforts in preparing the book. These efforts include the          *
 * development, research, and testing of the theories and programs        *
 * to determine their effectiveness. The authors and publisher make       *
 * no warranty of any kind, expressed or implied, with regard to these    *
 * programs or to the documentation contained in these books. The authors *
 * and publisher shall not be liable in any event for incidental or       *
 * consequential damages in connection with, or arising out of, the       *
 * furnishing, performance, or use of these programs.                     *
 *************************************************************************/
