/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package targetCode;


import java.util.ArrayList; 

public class Class78 implements Class1, Class97, Class102 
{
    protected int state = 0;
    protected ArrayList<Class81> observerList = new ArrayList<Class81>();
    protected static Class2 field583 = null;
    protected Class58 field584 = null;
    private Class112 field585 = null;
    protected Class178 field586 = null;
    private static Class201 field587 = null;
    public Class208 field588 = null;
    public static Class230 field589 = null;
    protected Class274 field590 = null;
    public static Class294 field591 = null;

    public Class78()
    {

    }


    public Class78(int arg59, Class41 arg471, Class30 arg482, Class63 arg492, Class100 arg548)
    {

        field583 = new Class2();
        field584 = new Class58();
        field585 = new Class112();
        field586 = new Class178(arg471);
        field587 = new Class201();
        field588 = new Class208();
        field589 = new Class230(arg548);
        field590 = new Class274(arg482);
        field591 = new Class294(arg492);

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
    public void attach(Class81 observer)
    {
        observerList.add(observer);

    }

    /**
     * 
     * @param observer 
     */
    public void detach(Class81 observer)
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
     */
    public void method375()
    {
    }

    /**
     *  
     */
    protected void method920()
    {
        Class15 field3157 = new Class15();
        field3157.method919(0.30077398884804574);

    }

    /**
     *  
     */
    private void method922()
    {
        Class18 field3158 = new Class18();
        field3158.method921(0.8672879241318197, "JB76E64T");

    }

    /**
     *  
     */
    public void method924()
    {
        Class33 field3159 = new Class33();
        field3159.method923(209227);

    }

    /**
     * 
     * @param arg1465 
     */
    protected void method926(Class84 arg1465)
    {
        Class83 field3160 = new Class83(arg1465);
        field3160.method925("PGYI");

    }

    /**
     *  
     */
    protected void method928()
    {
        Class95 field3161 = new Class95();
        field3161.method927("P1R");

    }

    /**
     *  
     */
    protected void method930()
    {
        Class143 field3162 = new Class143();
        field3162.method929(517474);

    }

    /**
     *  
     */
    protected void method932()
    {
        Class241 field3163 = new Class241();
        field3163.method931();

    }

    /**
     * 
     * @param arg1469 
     */
    public void method934(Class145 arg1469)
    {
        Class252 field3164 = new Class252(arg1469);
        field3164.method933(0.4091344f);

    }

    /**
     * 
     * @param arg1742 
     */
    public void method1467(int arg1742)
    {
    }

    /**
     * 
     * @param arg1854 
     */
    public void method1673(double arg1854)
    {
    }

    /**
     * 
     * @param arg1866 
     */
    public void method1697(float arg1866)
    {
    }

    /**
     *  
     */
    public void method1849()
    {
    }

    /**
     *  
     */
    public void method2177()
    {
    }

    /**
     *  
     */
    public void method2523()
    {
    }

    /**
     * 
     * @param arg2749
     * @param arg2750 
     */
    public void method3461(int arg2749, boolean arg2750)
    {
    }

    /**
     * 
     * @param arg3126 
     */
    public void method4121(int arg3126)
    {
    }

    /**
     * 
     * @param arg3159 
     */
    public void method4205(double arg3159)
    {
    }

    /**
     *  
     */
    @Override
    public Class3 iMethod1()
    {
        return new Class3();

    }

    /**
     * 
     * @param strategy 
     */
    @Override
    public void iMethod24(Class96 strategy)
    {
    }

    /**
     *  
     */
    @Override
    public void iMethod25()
    {
    }

    /**
     * 
     * @param elementA 
     */
    @Override
    public void iMethod31(Class133 elementA)
    {
    }

    /**
     * 
     * @param elementB 
     */
    @Override
    public void iMethod32(Class134 elementB)
    {
    }
}