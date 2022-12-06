package gui;

import person.Person;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

public class WindowsControl {
    JFrame jf=new JFrame();
    JFrame jf2=new JFrame();
    static ArrayList<Person> list =new ArrayList<>();
    boolean flag=false;
    boolean flag2=false;
    Random r=new Random();
    String guess;
    Date date=new Date();
    static String money;

//注册页面
    public void show(){
        mainDow();
        control();
    }
    private void mainDow(){
        jf2.setVisible(true);
        jf2.setSize(350,500);
        jf2.setDefaultCloseOperation(3);
        jf2.setTitle("注册");
        jf2.setLocationRelativeTo(null);
        jf2.setLayout(null);
        jf2.setAlwaysOnTop(true);

        JLabel jel=new JLabel("账号");
        JLabel jel2=new JLabel("密码");
        JLabel jel3=new JLabel("用户名");
        JLabel jel4=new JLabel("账户金额");
        JLabel jel5=new JLabel("电话号码");
        jel.setBounds(60,55,30,20);
        jel2.setBounds(60,100,30,20);
        jel3.setBounds(55,145,40,20);
        jel4.setBounds(40,190,60,20);
        jel5.setBounds(40,235,60,20);
        jf2.add(jel);
        jf2.add(jel2);
        jf2.add(jel3);
        jf2.add(jel4);
        jf2.add(jel5);
    }
    private void control() {
        JButton jb=new JButton("注册");
        JButton jb2=new JButton("返回");
        jb.setBounds(100,300,60,30);
        jf2.add(jb);
        jb2.setBounds(180,300,60,30);
        jf2.add(jb2);

        JTextField jt=new JTextField();
        JTextField jt2=new JTextField();
        JTextField jt3=new JTextField();
        JTextField jt4=new JTextField();
        JTextField jt5=new JTextField();
        jt.setBounds(100,55,150,20);
        jt2.setBounds(100,100,150,20);
        jt3.setBounds(100,145,150,20);
        jt4.setBounds(100,190,150,20);
        jt5.setBounds(100,235,150,20);
        jf2.add(jt);
        jf2.add(jt2);
        jf2.add(jt3);
        jf2.add(jt4);
        jf2.add(jt5);

        jb2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jf2.dispose();
            }
        });
        jb.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id=jt.getText();
                String password=jt2.getText();
                String name=jt3.getText();
                money=jt4.getText();
                String phoneNumber=jt5.getText();

                boolean flag=isExist(id);
                if(flag!=true){
                    Person person = new Person(id, name, password, money, phoneNumber);
                    list.add(person);
                    JOptionPane.showMessageDialog(jf2, "注册成功");
                }else{
                    JOptionPane.showMessageDialog(jf2, "注册失败");
                }
                jf2.dispose();
                turnNull();
            }

            private void turnNull() {
                jt.setText("");
                jt2.setText("");
                jt3.setText("");
                jt4.setText("");
                jt5.setText("");


            }

        });
    }

    private boolean isExist(String id) {
        boolean flag=false;
        for (int i = 0; i < list.size(); i++) {
            if(id.equals(list.get(i).getId())){
                flag=true;
                break;
            }
        }
        return flag;
    }

//登录界面
    public void mainWindows(){
        mainMethod();
        textMethod();
        jfButton();
    }

    private void jfButton() {

        JTextField jt=new JTextField();
        JTextField jt2=new JTextField();
        jt.setBounds(100,155,150,20);
        jt2.setBounds(100,200,150,20);
        jf.add(jt);
        jf.add(jt2);

        JButton jb=new JButton("登录");
        JButton jb2=new JButton("注册");
        jb.setBounds(100,300,60,30);
        jf.add(jb);
        jb2.setBounds(180,300,60,30);
        jf.add(jb2);

        jb.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id=jt.getText();
                String password=jt2.getText();
                boolean flag=isExists(id,password);
                if(flag){
                    //跳转到赌博页面
                    JOptionPane.showMessageDialog(jf, "登陆成功");
                    jf.dispose();
                    gemble();

                }else{
                    JOptionPane.showMessageDialog(jf, "账号或密码错误");
                }
                turnNull();
                //登录
            }

            private void turnNull() {
                jt.setText("");
                jt2.setText("");
            }
        });
        jb2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                show();
            }
        });
    }

    private boolean isExists(String id, String password) {
        boolean flag=false;
        for (int i = 0; i < list.size(); i++) {
            if(id.equals(list.get(i).getId())&&password.equals(list.get(i).getPassword())){
                flag=true;
                break;
            }
        }
        return flag;
    }

    private void textMethod() {
        JLabel jel=new JLabel("账号");
        JLabel jel2=new JLabel("密码");
        jel.setBounds(60,150,30,20);
        jf.add(jel);
        jel2.setBounds(60,200,30,20);
        jf.add(jel2);
    }
    private void mainMethod() {
        jf.setVisible(true);
        jf.setSize(350,500);
        jf.setDefaultCloseOperation(3);
        jf.setTitle("彩票抽奖");
        jf.setLocationRelativeTo(null);
        jf.setLayout(null);
    }

    //赌博页面

    private void gemble() {
        JFrame jf33=new JFrame();
        jf33.setVisible(true);
        jf33.setSize(350,500);
        jf33.setDefaultCloseOperation(3);
        jf33.setTitle("gamble");
        jf33.setLocationRelativeTo(null);
        jf33.setLayout(null);
        jf33.setAlwaysOnTop(true);

        JButton jb=new JButton("手动选号");
        JButton jb2=new JButton("随机选号");
        JButton jb3=new JButton("开始抽奖");
        jb.setBounds(60,400,100,30);
        jf33.add(jb);
        jb2.setBounds(180,400,100,30);
        jf33.add(jb2);
        jb3.setBounds(110,270,100,30);
        jf33.add(jb3);

        JTextField jf=new JTextField();
        JTextField jf2=new JTextField();
        JTextField jf3=new JTextField();
        JTextField jf4=new JTextField();
        JTextField jf5=new JTextField();
        JTextField jf6=new JTextField();

        jf.setBounds(65,50,50,50);
        jf2.setBounds(115,50,50,50);
        jf3.setBounds(165,50,50,50);
        jf4.setBounds(215,50,50,50);
        jf5.setBounds(115,150,50,50);
        jf6.setBounds(165,150,50,50);

        jf33.add(jf);
        jf33.add(jf2);
        jf33.add(jf3);
        jf33.add(jf4);
        jf33.add(jf5);
        jf33.add(jf6);

        JTextField jf8=new JTextField();
        jf8.setBounds(270,15,50,30);
        jf33.add(jf8);
        jf8.setText(money);

        JLabel jl=new JLabel("中奖号码为：");
        JLabel jl2=new JLabel("您选择的号码为：");
        jl.setBounds(20,15,100,40);
        jl2.setBounds(20,320,200,40);
        jf33.add(jl);
        jf33.add(jl2);

        JTextField jf7=new JTextField();
        jf7.setBounds(50,350,220,20);
        jf33.add(jf7);


        jb2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                flag=true;
                String guess1=r.nextInt(10)+"";
                String guess2=r.nextInt(10)+"";
                String guess3=r.nextInt(10)+"";
                String guess4=r.nextInt(10)+"";
                String guess5=r.nextInt(10)+"";
                String guess6=r.nextInt(10)+"";
                String guess7=r.nextInt(10)+"";
                guess=guess1+guess2+guess3+guess4+guess5+guess6+guess7;
                jf7.setText(guess);

                String a1=jf.getText();
                String b1=jf2.getText();
                String c1=jf3.getText();
                String d1=jf4.getText();
                String e1=jf5.getText();
                String f1=jf6.getText();
                String g=a1+b1+c1+d1+e1+f1;
                if(g.equals(guess)){
                    JOptionPane.showMessageDialog(jf, "中奖啦！！！");
                }else{
                    JOptionPane.showMessageDialog(jf, "很抱歉，未中奖，谢谢参与！");
                }
            }
        });

        jb.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                flag=true;
                String day1=jf7.getText();
                String a1=jf.getText();
                String b1=jf2.getText();
                String c1=jf3.getText();
                String d1=jf4.getText();
                String e1=jf5.getText();
                String f1=jf6.getText();
                String g=a1+b1+c1+d1+e1+f1;
                if(day1.equals(g)){
                    JOptionPane.showMessageDialog(jf, "中奖啦！！！");
                }else{
                    JOptionPane.showMessageDialog(jf, "很抱歉，未中奖，谢谢参与！");
                }
            }
        });
        jb3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int A = Integer.valueOf(money);
                A=A-50;
                money=A+"";
                if(A<=0){
                    JOptionPane.showMessageDialog(jf, "您的账户余额已耗尽，请重新充值");
                    jf33.dispose();
                }
                jf8.setText(money);

                        int a=r.nextInt(10);
                        jf.setText(a+"");
                        int b=r.nextInt(10);
                        jf2.setText(b+"");
                        int c=r.nextInt(10);
                        jf3.setText(c+"");
                        int d=r.nextInt(10);
                        jf4.setText(d+"");
                        int e1=r.nextInt(10);
                        jf5.setText(e1+"");
                        int f=r.nextInt(10);
                        jf6.setText(f+"");

            }
        });

    }
}