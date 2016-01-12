package com.huai.model.composite;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * 组合模式
 * <p>文件夹和文件是两种不同的对象，但是，我们可以利用组合模式统一对待它们。</p>
 * <p>文件夹1中有文件夹2或者文件2，文件夹2中可以有文件夹3或者文件3，
 * 在Window操作系统上面，我们统一对待文件夹和文件，双击它们，都可以“打开”，
 * 如果是文件夹，就直接打开，如果是文件，就另外启动相应的软件运行这个文件。</p>
 * <p>下面的代码中，我们把文件和文件夹统一看成是文件（File），所以我们定义了抽象类File，</p>
 * Created by liangyh on 16-1-3.
 */
public class CompositeTest {
    public static void main(String[] args) {
        Fold fold1 = new Fold("fold 1");
        ImageFile imageFile1 = new ImageFile("image file 1");
        TextFile textFile1 = new TextFile("text file 1");
        Fold fold2 = new Fold("fold 2");

        fold1.add(imageFile1);
        fold1.add(textFile1);
        fold1.add(fold2);

        ImageFile imageFile2 = new ImageFile("image file 2");
        TextFile textFile2 = new TextFile("text file 2");
        Fold fold3 = new Fold("fold 3");

        fold2.add(imageFile2);
        fold2.add(textFile2);
        fold2.add(fold3);

        fold1.display();
        fold2.display();
    }
}

abstract class File{
    private String name;

    public File(){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    abstract void display();
}

class Fold extends File{
    private final List<File> files = new ArrayList<>();
    private String name;

    public Fold(String name){
        this.name = name;
    }

    public void add(File file){
        files.add(file);
    }

    public File remove(File file){
        files.remove(file);
        return file;
    }

    @Override
    void display() {
        for (File file: files){
//            System.out.println(file.getName());
            file.display();
        }
    }

}

class ImageFile extends File{

    private String name;

    public ImageFile(String name){
        this.name = name;
    }

    @Override
    void display() {
        System.out.println(name);
    }
}

class TextFile extends File{
    private String name;

    public TextFile(String name){
        this.name = name;
    }

    @Override
    void display() {
        System.out.println(name);
    }
}