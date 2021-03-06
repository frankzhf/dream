/* Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.activiti.engine.impl.persistence.entity;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import org.activiti.engine.identity.Picture;
import org.activiti.engine.identity.User;
import org.activiti.engine.impl.cmd.SaveUserCmd;
import org.activiti.engine.impl.context.Context;
import org.activiti.engine.impl.db.PersistentObject;


/**
 * @author Tom Baeyens
 */
public class UserEntity implements User, Serializable, PersistentObject {

  private static final long serialVersionUID = 1L;

  protected String id;
  protected int revision;
  protected String firstName;
  protected String lastName;
  protected String email;
  protected String password;
  
  protected String pictureByteArrayId;
  protected ByteArrayEntity pictureByteArray;
  
  public UserEntity() {
  }
  
  public UserEntity(String id) {
    this.id = id;
  }
  
  /** update this user by copying all the given user's signalData into this user.
   * @see SaveUserCmd */
  public void update(UserEntity user) {
    this.firstName = user.getFirstName();
    this.lastName = user.getLastName();
    this.email = user.getEmail();
    this.password = user.getPassword();
  }
  
  public Object getPersistentState() {
    Map<String, Object> persistentState = new HashMap<String, Object>();
    persistentState.put("firstName", firstName);
    persistentState.put("lastName", lastName);
    persistentState.put("email", email);
    persistentState.put("password", password);
    persistentState.put("pictureByteArrayId", pictureByteArrayId);
    return persistentState;
  }
  
  public int getRevisionNext() {
    return revision+1;
  }
  
  public Picture getPicture() {
    if (pictureByteArrayId==null) {
      return null;
    }
    ByteArrayEntity pictureByteArray = getPictureByteArray();
    return new Picture(pictureByteArray.getBytes(), pictureByteArray.getName());
  }
  
  public void setPicture(Picture picture) {
    if (pictureByteArrayId!=null) {
      Context
        .getCommandContext()
        .getDbSqlSession()
        .delete(ByteArrayEntity.class, pictureByteArrayId);
    }
    if (picture!=null) {
      pictureByteArray = new ByteArrayEntity(picture.getMimeType(), picture.getBytes());
      Context
        .getCommandContext()
        .getDbSqlSession()
        .insert(pictureByteArray);
      pictureByteArrayId = pictureByteArray.getId();
    } else {
      pictureByteArrayId = null;
      pictureByteArray = null;
    }
  }

  private ByteArrayEntity getPictureByteArray() {
    if (pictureByteArrayId!=null && pictureByteArray==null) {
      pictureByteArray = Context
        .getCommandContext()
        .getDbSqlSession()
        .selectById(ByteArrayEntity.class, pictureByteArrayId);
    }
    return pictureByteArray;
  }


  public String getId() {
    return id;
  }
  public void setId(String id) {
    this.id = id;
  }
  public String getFirstName() {
    return firstName;
  }
  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }
  public String getLastName() {
    return lastName;
  }
  public void setLastName(String lastName) {
    this.lastName = lastName;
  }
  public String getEmail() {
    return email;
  }
  public void setEmail(String email) {
    this.email = email;
  }
  public String getPassword() {
    return password;
  }
  public void setPassword(String password) {
    this.password = password;
  }
  public int getRevision() {
    return revision;
  }
  public void setRevision(int revision) {
    this.revision = revision;
  }
  public String getPictureByteArrayId() {
    return pictureByteArrayId;
  }
  public void setPictureByteArrayId(String pictureByteArrayId) {
    this.pictureByteArrayId = pictureByteArrayId;
  }
}
