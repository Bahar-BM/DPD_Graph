/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package targetCode;

 

public class Class52 
{
    private Class50 subject = null;
    public Class18 field116 = null;
    public Class30 field117 = null;
    protected Class104 field118 = null;

    public Class52()
    {

        Class51 concreteObserver1 = new Class51();
        Class51 concreteObserver2 = new Class51();
        subject.attach(concreteObserver1);
        subject.attach(concreteObserver2);
        subject.notifyObservers();

    }


    public Class52(int arg39)
    {

        subject = new Class50();
        field116 = new Class18();
        field117 = new Class30();
        field118 = new Class104();

    }



    /**
     * 
     * @param arg183
     * @param arg184 
     */
    public void method51(double arg183, double arg184)
    {
    }

    /**
     * 
     * @param arg187 
     */
    public void method59(String arg187)
    {
    }
}