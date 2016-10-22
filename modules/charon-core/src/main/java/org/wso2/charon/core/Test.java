package org.wso2.charon.core;

import org.wso2.charon.core.config.SCIMUserSchemaExtensionBuilder;
import org.wso2.charon.core.encoder.JSONDecoder;
import org.wso2.charon.core.encoder.JSONEncoder;
import org.wso2.charon.core.exceptions.CharonException;
import org.wso2.charon.core.exceptions.InternalErrorException;
import org.wso2.charon.core.protocol.SCIMResponse;
import org.wso2.charon.core.protocol.endpoints.AbstractResourceManager;
import org.wso2.charon.core.protocol.endpoints.UserResourceManager;
import org.wso2.charon.core.schema.SCIMConstants;

import java.util.HashMap;

/**
 * This class is only for testing purpose.
 */
public class Test {

   public static void main(String [] args){
       UserResourceManager um =new UserResourceManager();
       um.setEncoder(new JSONEncoder());
       um.setDecoder(new JSONDecoder());
       HashMap hmp=new HashMap<String,String>();
       hmp.put(SCIMConstants.USER_ENDPOINT,"http://localhost:8080/scim/v2/Users");
       um.setEndpointURLMap(hmp);
       //-----Extension User schema support------
       SCIMUserSchemaExtensionBuilder extensionBuilder= new SCIMUserSchemaExtensionBuilder();
       try {
           extensionBuilder.buildUserSchemaExtension("/home/vindula/Desktop/Charon/Charon-3.0/scim-schema-extension.config");
       } catch (CharonException e) {
           e.printStackTrace();
       } catch (InternalErrorException e) {
           e.printStackTrace();
       }

       String array ="{\n" +
               "  \"schemas\": [\"urn:ietf:params:scim:schemas:core:2.0:User\"],\n" +
               "  \"id\":\"23232\",\n"+
               "  \"externalId\": \"701984\",\n" +
               "  \"urn:ietf:params:scim:schemas:core:2.0:User:userName\": \"bigboss@wso2.com\",\n" +
               "  \"password\": \"testpass\",\n" +
               "  \"name\": {\n" +
               "    \"formatted\": \"Ms. Barbara J Jensen, III\",\n" +
               "    \"familyName\": \"Sachini\",\n" +
               "    \"givenName\": \"VJ\",\n" +
               "    \"middleName\": \"Jane\",\n" +
               "    \"honorificPrefix\": \"Ms.\",\n" +
               "    \"honorificSuffix\": \"III\"\n" +
               "  },\n" +
               "  \"displayName\": \"Babs Jensen\",\n" +
               "  \"nickName\": \"Babs\",\n" +
               "  \"profileUrl\": \"https://login.example.com/bjensen\",\n" +
               "  \"emails\": [\n" +
               "    {\n" +
               "      \"value\": \"yysd@example.com\",\n" +
               "      \"type\": \"work\",\n" +
               "      \"primary\": true\n" +
               "    },\n" +
               "    {\n" +
               "      \"value\": \"uu@jensen.org\",\n" +
               "      \"type\": \"work\"\n" +
               "    }\n" +
               "  ],\n"+
               "  \"addresses\": [\n"+
               "    { \n"+
               "        \"type\": \"work\",\n"+
               "        \"streetAddress\": \"100 Universal City Plaza\",\n"+
               "        \"locality\": \"Hollywood\",\n"+
               "        \"region\": \"CA\",\n"+
               "        \"postalCode\": \"91608\",\n"+
               "        \"country\": \"USA\",\n"+
               "        \"formatted\": \"100 Universal City Plaza Hollywood, CA 91608 USA\",\n"+
               "        \"primary\": true\n"+
               "    }\n"+
               "]," +
               "  \"urn:scim:schemas:extension:wso2:1.0:wso2Extension\": {\n" +
               "    \"employeeNumber\":{\n" +
               "        \"value\": \"ODEL\", \n" +
               "        \"display\": \"NoLimit\" \n" +
               "      },\n" +
               "    \"sister\": \"Dushanis\",\n" +
               "    \"owners\": [\"Sakditha\",\"Mildinda\"],\n" +
               "    \"dogs\": [\n" +
               "    {\n" +
               "        \"boss\": \"micky\", \n" +
               "        \"value\": \"li1sa\" \n" +
               "    },\n" +
               "    {\n" +
               "        \"boss\": \"lisa\", \n" +
               "        \"value\": \"lisaa\" \n" +
               "    }\n" +
               "      ]\n" +
               "  }\n" +
               "}";

       String attributes="wso2Extension.sister";
       String excludeAttributes="externalId,emails.value,wso2Extension.employeeNumber.display";

       //----CREATE USER --------
       //SCIMResponse res=um.create(array,new SCIMUserManager(),null, null);


       //-----GET USER  ---------
       //SCIMResponse res= um.get("a713e12b-0364-4d54-b939-6d1230d40251",new SCIMUserManager(),null,null);

       //-----DELETE USER  ---------
       //SCIMResponse res= um.delete("cf712155-e974-42ae-9e57-6c42f7bbadad",new SCIMUserManager());

       //-----LIST USER  ---------
       //SCIMResponse res= um.list(new SCIMUserManager(),attributes,null);

       //-----LIST USER WITH PAGINATION ---------
       //SCIMResponse res= um.listWithPagination(1,7,new SCIMUserManager(),null,null);

       //-----UPDATE USER VIA PUT ---------
       SCIMResponse res= um.updateWithPUT("f38508e0-40f7-4a74-b2a1-1b602939b172",array,new SCIMUserManager(),null,null);

       //-----FILTER AT USER ENDPOINT ---------
       String filter ="userName eq johan@wso2.com";
       //SCIMResponse res= um.listByFilter(filter, new SCIMUserManager(), attributes, null);

       //-----LIST USERS WITH SORT ---------
       //SCIMResponse res= um.listBySort(null,"AsCEnding",new SCIMUserManager(),attributes,null);

       //-----UPDATE USERS WITH PATCH ---------
       //SCIMResponse res= um.updateWithPATCH(null,null,new SCIMUserManager(),attributes,null);


       System.out.println(res.getResponseStatus());
       System.out.println("");
       System.out.println(res.getHeaderParamMap());
       System.out.println("");
       System.out.println(res.getResponseMessage());
   }

}
