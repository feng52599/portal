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
        return "\n��Ӧ����Ϣ��\n��Ӧ�����ƣ�" + this.supplier
                + "����ϵ��ַ��" + this.address
                + "����ϵ�绰��" + this.telephone;
    }
}
