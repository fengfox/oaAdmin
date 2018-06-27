package com.scal.oa.Service;


import org.apache.cxf.endpoint.Client;
import org.apache.cxf.jaxws.endpoint.dynamic.JaxWsDynamicClientFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Value("${webservice.portal}")
    private String portal;
    public boolean login(String userName,String pwd)
    {
        JaxWsDynamicClientFactory dcf = JaxWsDynamicClientFactory.newInstance();
        Client client = dcf.createClient(portal);
        Object[] objects = new Object[0];
                 try {
                     objects = client.invoke("validatorLegalUser", userName,pwd);
                     if(objects[0].toString().indexOf("<code>0</code>")!=-1)
                     {
                         //todo保存session
                         return true;
                     }
                     else
                     {
                         return false;
                     }

                 } catch (java.lang.Exception e) {
                     return false;
                 }

    }

}
