/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package targetCode;


import java.util.ArrayList; 

public class Class53 
{
    protected int state = 0;
    protected ArrayList<Class56> observerList = new ArrayList<Class56>();
    public static Class16 field119 = null;
    protected Class52 field120 = null;
    public Class72 field121 = null;
    private Class104 field122 = null;
    private Class132 field123 = null;

    public Class53()
    {

    }


    public Class53(int arg40)
    {

        field119 = new Class16();
        field120 = new Class52();
        field121 = new Class72();
        field122 = new Class104();
        field123 = new Class132();

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
    public void attach(Class56 observer)
    {
        observerList.add(observer);

    }

    /**
     * 
     * @param observer 
     */
    public void detach(Class56 observer)
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
    public void method111()
    {
    }

    /**
     *  
     */
    protected void method182()
    {
        Class10 field494 = new Class10();
        field494.method181("RMI");

    }

    /**
     *  
     */
    public void method184()
    {
        Class45 field495 = new Class45();
        field495.method183();

    }

    /**
     *  
     */
    protected void method186()
    {
        Class76 field496 = new Class76();
        field496.method185();

    }

    /**
     *  
     */
    protected void method188()
    {
        Class104 field497 = new Class104();
        field497.method187();

    }

    /**
     * 
     * @param arg253 
     */
    public void method201(String arg253)
    {
    }
}