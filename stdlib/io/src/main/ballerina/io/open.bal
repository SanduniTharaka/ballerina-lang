// Copyright (c) 2017 WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
//
// WSO2 Inc. licenses this file to you under the Apache License,
// Version 2.0 (the "License"); you may not use this file except
// in compliance with the License.
// You may obtain a copy of the License at
//
// http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing,
// software distributed under the License is distributed on an
// "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
// KIND, either express or implied.  See the License for the
// specific language governing permissions and limitations
// under the License.

//# Represents the set of permissions supported to open file.
//#
//# READ - open the file in read mode
//# WRITE - open the file in write mode
//# READ/WRITE - open the file either to read or write
//# APPEND - append to existing file instead of replacing
public type Mode "r"|"w"|"rw"|"a";
@final public Mode READ = "r";
@final public Mode WRITE = "w";
@final public Mode RW = "rw";
@final public Mode APPEND = "a";

# Retrieves a ReadableByteChannel from a given file path.
#
# + path - Relative/absolute path string to locate the file
# + return - ByteChannel representation of the file resource
public extern function openReadableFile(@sensitive string path) returns @tainted ReadableByteChannel;

# Retrieves a WritableByteChannel from a given file path.
#
# + path - Relative/absolute path string to locate the file
# + return - ByteChannel representation of the file resource
public extern function openWritableFile(@sensitive string path, boolean append = false)
    returns @tainted WritableByteChannel;

# Opens a secure socket connection with a remote server.
#
# + host - Remote server domain/IP
# + port - Remote server port
# + options - Mata data to initialize the connection(i.e security information)
# + return - Socket which will represent the network object or an error
public extern function openSecureSocket(@sensitive string host,
                                        @sensitive int port,
                                        SocketProperties options) returns @tainted Socket|error;

# Creates an in-memory channel which will reference stream of bytes.
#
# + content - Content which should be exposed as channel
# + return - ByteChannel represenation to read the memory content
public extern function createReadableChannel(byte[] content) returns ReadableByteChannel;

