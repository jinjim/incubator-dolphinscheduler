/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.dolphinscheduler.server.master.host;


import java.util.Objects;


public class Host {

    private String address;

    private String ip;

    private int port;

    public Host() {
    }

    public Host(String ip, int port) {
        this.ip = ip;
        this.port = port;
        this.address = ip + ":" + port;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
        this.address = ip + ":" + port;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
        this.address = ip + ":" + port;
    }

    public static Host of(String address){
        String[] parts = address.split(":");
        if (parts.length != 2) {
            throw new IllegalArgumentException(String.format("Address : %s illegal.", address));
        }
        Host host = new Host(parts[0], Integer.parseInt(parts[1]));
        return host;
    }

    @Override
    public String toString() {
        return "Host{" +
                "address='" + address + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Host host = (Host) o;
        return Objects.equals(getAddress(), host.getAddress());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getAddress());
    }
}