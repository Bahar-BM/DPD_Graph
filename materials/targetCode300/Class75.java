/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package targetCode;


import java.util.ArrayList; 

public class Class75 
{
    private int state = 0;
    private ArrayList<Class76> observerList = new ArrayList<Class76>();
    public Class22 field152 = null;
    public Class15 field559 = null;
    private Class156 field560 = null;
    protected Class169 field561 = null;
    private Class239 field562 = null;
    public Class240 field563 = null;
    public Class244 field564 = null;
    public Class293 field565 = null;
    protected static Class297 field566 = null;

    public Class75()
    {

    }


    public Class75(int arg56, Class22 arg302, Class140 arg629, Class216 arg839)
    {

        field152 = arg302;
        field559 = new Class15();
        field560 = new Class156();
        field561 = new Class169();
        field562 = new Class239();
        field563 = new Class240();
        field564 = new Class244(arg839);
        field565 = new Class293(arg629);
        field566 = new Class297();

    }



    /**
     *  
     */
    public void notifyObservers()
    {
        for ( int i = 0 ; i<observerList.size() ; i = i + 1 )
        {
            observerList.get(i).update(this);

        }

    }

    /**
     * 
     * @param observer 
     */
    public void attach(Class76 observer)
    {
        observerList.add(observer);

    }

    /**
     * 
     * @param observer 
     */
    public void detach(Class76 observer)
    {
        observerList.remove(observer);

    }

    /**
     * 
     * @param newState 
     */
    public void setState(int newState)
    {
        state = newState;

    }

    /**
     *  
     */
    public int getState()
    {
        return state;

    }

    /**
     * 
     * @param arg1208 
     */
    public void method373(String arg1208)
    {
    }

    /**
     * 
     * @param arg1280
     * @param arg1281 
     */
    public void method525(String arg1280, double arg1281)
    {
    }

    /**
     *  
     */
    public void method749()
    {
    }

    /**
     *  
     */
    public void method880()
    {
        Class10 field3137 = new Class10();
        field3137.method879();

    }

    /**
     *  
     */
    public void method882()
    {
        Class12 field3138 = new Class12();
        field3138.method881("NNEUEA3PX");

    }

    /**
     *  
     */
    public void method884()
    {
        Class61 field3139 = new Class61();
        field3139.method883(true);

    }

    /**
     *  
     */
    protected void method886()
    {
        Class133 field3140 = new Class133();
        field3140.method885(true, false);

    }

    /**
     *  
     */
    protected void method888()
    {
        Class179 field3141 = new Class179();
        field3141.method887(0.7306475f);

    }

    /**
     *  
     */
    public void method890()
    {
        Class205 field3142 = new Class205();
        field3142.method889();

    }

    /**
     *  
     */
    public void method892()
    {
        Class215 field3143 = new Class215();
        field3143.method891(false);

    }

    /**
     *  
     */
    public void method894()
    {
        Class240 field3144 = new Class240();
        field3144.method893("UR5HPX");

    }

    /**
     * 
     * @param arg1986 
     */
    public void method1959(float arg1986)
    {
    }
}