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
        return "��˾���ƣ�" + name + "\n��ַ��" + address + "\t��ϵ��ʽ:" + tel;
    }

    public void callsuppliers() {

        String answer = CInput.readString("�Ƿ���Ҫ��ϵ��Ӧ�̲�ѯ��棿��Ҫ������Y������Ҫ������N��");

        if (answer.equals("Y")) {
            System.out.println("����绰�У�" + tel);
            System.out.println("���Ժ�");
            int[] a = new int[1];

            for (int i = 0; i < a.length; i++) {
                a[i] = (int) (Math.random() * 3) + 1;
                if (a[i] == 1)
                    System.out.print("������ĵ绰����ͨ���У����Ժ��ٲ���");
                if (a[i] == 2)
                    System.out.print("������ĵ绰��ʱ�޷���ͨ�����Ժ��ٲ���");
                if (a[i] == 1)
                    System.out.print("�����У����Ժ�");
            }

        } else if (answer.equals("N")) {
            System.out.println("ллʹ��");
        }
    }

}
