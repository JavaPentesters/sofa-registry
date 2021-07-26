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
package com.alipay.sofa.registry.common.model.metaserver;

import com.google.common.base.Objects;
import java.util.Map;

/**
 * @author xiaojian.xj
 * @version $Id: ClientManagerAddress.java, v 0.1 2021年06月16日 21:21 xiaojian.xj Exp $
 */
public class ClientManagerAddress {

  private final long version;

  private final Map<String, AddressVersion> clientOffAddress;

  public ClientManagerAddress(long version, Map<String, AddressVersion> clientOffAddress) {
    this.version = version;
    this.clientOffAddress = clientOffAddress;
  }

  /**
   * Getter method for property <tt>version</tt>.
   *
   * @return property value of version
   */
  public long getVersion() {
    return version;
  }

  /**
   * Getter method for property <tt>clientOffAddress</tt>.
   *
   * @return property value of clientOffAddress
   */
  public Map<String, AddressVersion> getClientOffAddress() {
    return clientOffAddress;
  }

  @Override
  public String toString() {
    return "ClientManagerAddress{" +
            "version=" + version +
            ", clientOffAddress=" + clientOffAddress +
            '}';
  }

  public static class AddressVersion {
    private final long version;

    private final String address;

    public AddressVersion(long version, String address) {
      this.version = version;
      this.address = address;
    }

    /**
     * Getter method for property <tt>version</tt>.
     *
     * @return property value of version
     */
    public long getVersion() {
      return version;
    }

    /**
     * Getter method for property <tt>address</tt>.
     *
     * @return property value of address
     */
    public String getAddress() {
      return address;
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) {
        return true;
      }
      if (o == null || getClass() != o.getClass()) {
        return false;
      }
      AddressVersion that = (AddressVersion) o;
      return version == that.version && Objects.equal(address, that.address);
    }

    @Override
    public int hashCode() {
      return Objects.hashCode(version, address);
    }

    @Override
    public String toString() {
      return "AddressVersion{" +
              "version=" + version +
              ", address='" + address + '\'' +
              '}';
    }
  }
}
