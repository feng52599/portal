package cn.edu.neusoft.example.purchase;

public class Suppliers {

    public String name, address, tel;
    public int call;

    public Suppliers(String name, String address, String tel) {
        this.name = name;
        this.address = address;
        this.tel = tel;
    }

    public String toString() {
        return "公司名称：" + name + "\n地址：" + address + "\t联系方式:" + tel;
    }

    public void callsuppliers() {

        String answer = CInput.readString("是否需要联系供应商查询库存？需要请输入Y，不需要请输入N。");

        if (answer.equals("Y")) {
            System.out.println("拨打电话中：" + tel);
            System.out.println("请稍后");
            int[] a = new int[1];

            for (int i = 0; i < a.length; i++) {
                a[i] = (int) (Math.random() * 3) + 1;
                if (a[i] == 1)
                    System.out.print("您拨打的电话正在通话中，请稍后再拨。");
                if (a[i] == 2)
                    System.out.print("您拨打的电话暂时无法接通，请稍后再拨。");
                if (a[i] == 1)
                    System.out.print("接线中，请稍后");
            }

        } else if (answer.equals("N")) {
            System.out.println("谢谢使用");
        }
    }

}
