/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.slider.api.resource;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.apache.commons.lang.StringUtils;

/**
 * Set of configuration properties that can be injected into the application
 * components via envs, files and custom pluggable helper docker containers.
 * Files of several standard formats like xml, properties, json, yaml and
 * templates will be supported.
 **/

@ApiModel(description = "Set of configuration properties that can be injected into the application components via envs, files and custom pluggable helper docker containers. Files of several standard formats like xml, properties, json, yaml and templates will be supported.")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaClientCodegen", date = "2016-06-02T08:15:05.615-07:00")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Configuration implements Serializable {
  private static final long serialVersionUID = -4330788704981074466L;

  private Map<String, String> properties = new HashMap<String, String>();
  private Map<String, String> env = new HashMap<String, String>();
  private List<ConfigFile> files = new ArrayList<ConfigFile>();

  /**
   * A blob of key-value pairs of common application properties.
   **/
  public Configuration properties(Map<String, String> properties) {
    this.properties = properties;
    return this;
  }

  @ApiModelProperty(example = "null", value = "A blob of key-value pairs of common application properties.")
  @JsonProperty("properties")
  public Map<String, String> getProperties() {
    return properties;
  }

  public void setProperties(Map<String, String> properties) {
    this.properties = properties;
  }

  /**
   * A blob of key-value pairs which will be appended to the default system
   * properties and handed off to the application at start time. All placeholder
   * references to properties will be substituted before injection.
   **/
  public Configuration env(Map<String, String> env) {
    this.env = env;
    return this;
  }

  @ApiModelProperty(example = "null", value = "A blob of key-value pairs which will be appended to the default system properties and handed off to the application at start time. All placeholder references to properties will be substituted before injection.")
  @JsonProperty("env")
  public Map<String, String> getEnv() {
    return env;
  }

  public void setEnv(Map<String, String> env) {
    this.env = env;
  }

  /**
   * Array of list of files that needs to be created and made available as
   * volumes in the application component containers.
   **/
  public Configuration files(List<ConfigFile> files) {
    this.files = files;
    return this;
  }

  @ApiModelProperty(example = "null", value = "Array of list of files that needs to be created and made available as volumes in the application component containers.")
  @JsonProperty("files")
  public List<ConfigFile> getFiles() {
    return files;
  }

  public void setFiles(List<ConfigFile> files) {
    this.files = files;
  }

  public long getPropertyLong(String name, long defaultValue) {
    if (name == null) {
      return defaultValue;
    }
    String value = properties.get(name.trim());
    if (StringUtils.isEmpty(value)) {
      return defaultValue;
    }
    return Long.parseLong(value);
  }

  public String getProperty(String name, String defaultValue) {
    if (name == null) {
      return defaultValue;
    }
    return properties.get(name.trim());
  }

  public void setProperty(String name, String value) {
    properties.put(name, value);
  }

  public String getProperty(String name) {
    if (name == null) {
      return null;
    }
    return properties.get(name.trim());
  }

  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Configuration configuration = (Configuration) o;
    return Objects.equals(this.properties, configuration.properties)
        && Objects.equals(this.env, configuration.env)
        && Objects.equals(this.files, configuration.files);
  }

  @Override
  public int hashCode() {
    return Objects.hash(properties, env, files);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Configuration {\n");

    sb.append("    properties: ").append(toIndentedString(properties))
        .append("\n");
    sb.append("    env: ").append(toIndentedString(env)).append("\n");
    sb.append("    files: ").append(toIndentedString(files)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}
