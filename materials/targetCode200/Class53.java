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
    public Class10 field157 = null;
    private Class26 field158 = null;
    public Class69 field159 = null;
    private Class72 field160 = null;
    public Class124 field161 = null;
    public static Class182 field162 = null;

    public Class53()
    {

    }


    public Class53(int arg40)
    {

        field157 = new Class10();
        field158 = new Class26();
        field159 = new Class69();
        field160 = new Class72();
        field161 = new Class124();
        field162 = new Class182();

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
    public void method276()
    {
        Class42 field856 = new Class42();
        field856.method275();

    }

    /**
     *  
     */
    private void method278()
    {
        Class71 field857 = new Class71();
        field857.method277(0.9966261f, 0.9883007872105359);

    }

    /**
     *  
     */
    public void method280()
    {
        Class115 field858 = new Class115();
        field858.method279();

    }
}