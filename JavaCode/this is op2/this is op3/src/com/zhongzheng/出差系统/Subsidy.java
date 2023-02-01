package com.zhongzheng.出差系统;

public class Subsidy {
    final int 高层 = 0,主管 = 1,普通员工 = 2;
    final int 一线城市  = 0,二线城市 = 1,三线城市 = 2,四线城市 = 3;
    private int employeeGreat;
    private int cityGreat;
    private String numberOfEmployee;
    private int day;
    private double stayMany;
    private double trafficExpense;
    private double citySubsidy;
    private double staySubsidy;
    private double [][] many01 = {{700,600,500,400},{350,300,250,150},{270,230,200,150}};//    住宿补贴
    private double [] many02 = { 90,70,60,60};//    城市补贴
    private double[] beyond = {0.20,0.40,0.50};// 超出自费
    private double[] lower = {0.30,0.50,0.70};// 低于补贴

    public Subsidy() {
        super();
    }

    public Subsidy(String numberOfEmployee,int employeeGreat,int cityGreat,double trafficExpense,double stayMany,int day) {
        citySubsidy = many01[employeeGreat][cityGreat];
        staySubsidy = many02[cityGreat];
        this.trafficExpense = trafficExpense;
        this.numberOfEmployee = numberOfEmployee;
        this.stayMany = stayMany;
        this.day = day;
    }


    public double subsidyMany(){
        double many;
        double many02;
        if (stayMany > staySubsidy){
            many02 = 0 - (stayMany - staySubsidy) * beyond[employeeGreat];
        }else{
            many02 = (staySubsidy - stayMany) * lower[employeeGreat];
        }
        many = trafficExpense + citySubsidy * day + staySubsidy * day + many02 * day;
        return many;
    }


}
