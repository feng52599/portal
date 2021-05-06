package cn.edu.neusoft.javaclass.base;

public class Supply {

    public String supplier;
    public String address;
    public String telephone;

    public Supply(String supplier, String address, String telephone) {
        this.supplier = supplier;
        this.address = address;
        this.telephone = telephone;
    }

    public String toString() {
        return "\n供应商信息：\n供应商名称：" + this.supplier
                + "，联系地址：" + this.address
                + "，联系电话：" + this.telephone;
    }
}
