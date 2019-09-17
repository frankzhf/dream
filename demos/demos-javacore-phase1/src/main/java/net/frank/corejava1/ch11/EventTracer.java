package net.frank.corejava1.ch11;

import java.awt.*;
import java.beans.BeanInfo;
import java.beans.EventSetDescriptor;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/***
 * GUI应用中行到AWT事件记录功能实现
 */
public class EventTracer {

    private InvocationHandler handler;

    public EventTracer(){
        handler= new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args){
                System.out.println(method + ":" + args[0]);
                return null;
            }
        };
    }

    public void add(Component c){
        try{
            BeanInfo info = Introspector.getBeanInfo(c.getClass());
            EventSetDescriptor [] eventSets = info.getEventSetDescriptors();
            for(EventSetDescriptor eventSet: eventSets){
                addListener(c,eventSet);
            }
        }catch(IntrospectionException e){
        }
        if( c instanceof Container) {
            for(Component comp : ((Container)c).getComponents()){
                add(comp);
            }
        }
    }

    public void addListener(Component c ,EventSetDescriptor eventSet){
        Object proxy = Proxy.newProxyInstance(null,
                new Class[] {eventSet.getListenerType()},handler);
        Method addListenerMethod = eventSet.getAddListenerMethod();
        try{
            addListenerMethod.invoke(c,proxy);
        }catch (ReflectiveOperationException e){

        }
    }

}
