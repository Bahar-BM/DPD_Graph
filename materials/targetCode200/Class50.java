/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package targetCode;


import java.util.ArrayList; 

public class Class50 
{
    private int state = 0;
    private ArrayList<Class51> observerList = new ArrayList<Class51>();
    public Class78 field149 = null;
    private Class138 field150 = null;

    public Class50()
    {

    }


    public Class50(int arg37)
    {

        field149 = new Class78();
        field150 = new Class138();

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
    public void attach(Class51 observer)
    {
        observerList.add(observer);

    }

    /**
     * 
     * @param observer 
     */
    public void detach(Class51 observer)
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
     * @param arg253 
     */
    public void method93(double arg253)
    {
    }

    /**
     *  
     */
    public void method250()
    {
        Class11 field843 = new Class11();
        field843.method249(507531, "");

    }

    /**
     *  
     */
    protected void method252()
    {
        Class88 field844 = new Class88();
        field844.method251(0.7005240640289059);

    }

    /**
     *  
     */
    private void method254()
    {
        Class113 field845 = new Class113();
        field845.method253(false);

    }

    /**
     *  
     */
    public void method256()
    {
        Class161 field846 = new Class161();
        field846.method255();

    }

    /**
     *  
     */
    public void method258()
    {
        Class181 field847 = new Class181();
        field847.method257(283378);

    }

    /**
     * 
     * @param arg552 
     */
    public void method759(int arg552)
    {
    }

    /**
     *  
     */
    public void method789()
    {
    }
}