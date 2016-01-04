package com.huai.model.builder;

/**
 * 构建者模式：将一个复杂对象的构建与它的表示分离，
 * 使得同样的构建过程可以创建不同的表示。
 * Created by liangyh on 16-1-2.
 *
 */
public class BuilderPattern {
    /**
     * 机箱抽象类
     */
    abstract class Crate{
        @Override
        public String toString() {
            return "abstract crate...";
        }
    }
    /**
     * 酷冷至尊机箱
     */
    class CoolerMasterCrate extends Crate{
        @Override
        public String toString() {
            return "CoolerMaster crate...";
        }
    }
    /**
     * CPU抽象类
     */
    abstract class CPU{
        @Override
        public String toString() {
            return "abstract cpu...";
        }
    }
    /**
     * AMD CPU
     */
    class AMDCPU extends CPU{
        @Override
        public String toString() {
            return "AMD cpu...";
        }
    }
    /**
     * 主板抽象类
     */
    abstract class Motherboard{
        @Override
        public String toString() {
            return "abstract motherboard...";
        }
    }
    /**
     * 华硕主板
     */
    class ASUSMotherboard extends Motherboard{
        @Override
        public String toString() {
            return "ASUS motherboard...";
        }
    }
    /**
     * 电脑定义类
     */
    class Computer{
        CPU cpu; //cpu
        Motherboard motherboard; //主板
        Crate crate;//机箱

        @Override
        public String toString() {
            return "CPU:"+cpu+"\nMotherboard:"+motherboard+"\nCrate:"+crate;
        }
    }
    /**
     * 电脑构建者接口，可以将CPU等部件通过工厂模式来生产，以进一步分离产品部件生成和构建的过程...
     */
    interface ComputerBuilder{
        public ComputerBuilder buildCPU();
        public ComputerBuilder buildMotherboard();
        public ComputerBuilder buildCrate();
        public Computer getProduct();
    }
    /**
     * 最热台式电脑构建实现类
     */
    class HotDeskComputerBuilder implements ComputerBuilder{
        private Computer computer;
        public HotDeskComputerBuilder(){
            this.computer = new Computer();
        }

        @Override
        public ComputerBuilder buildCPU() {
            computer.cpu = new AMDCPU();
            return this;
        }

        @Override
        public ComputerBuilder buildMotherboard() {
            computer.motherboard = new ASUSMotherboard();
            return this;
        }

        @Override
        public ComputerBuilder buildCrate() {
            computer.crate = new CoolerMasterCrate();
            return this;
        }

        @Override
        public Computer getProduct() {
            buildMotherboard().buildCPU().buildCrate();
            return computer;
        }
    }

    /**
     * 导向器,客户端通过导向器获取产品，
     * 而不关心导向器是怎样获取到Builder生成器
     * 构建的产品对象的。而具体的构建过程则交给具体的Builder。
     */
    class Director{
        private ComputerBuilder builder;
        public Director(ComputerBuilder builder){
            this.builder = builder;
        }
        /**
         * 返回构造好的产品
         */
        public Computer construct(){
            return builder.getProduct();
        }
    }
    public static void main(String[] args) {
        BuilderPattern bp = new BuilderPattern();
        ComputerBuilder builder = bp.new HotDeskComputerBuilder();
        Director director = bp.new Director(builder);
        Computer computer = director.construct();
        System.out.println(computer);
    }
}