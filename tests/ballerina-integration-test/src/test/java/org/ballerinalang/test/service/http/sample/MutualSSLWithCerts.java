/*
 *  Copyright (c) 2018, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 *  WSO2 Inc. licenses this file to you under the Apache License,
 *  Version 2.0 (the "License"); you may not use this file except
 *  in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing,
 *  software distributed under the License is distributed on an
 *  "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 *  KIND, either express or implied.  See the License for the
 *  specific language governing permissions and limitations
 *  under the License.
 */

package org.ballerinalang.test.service.http.sample;

import org.ballerinalang.test.BaseTest;
import org.ballerinalang.test.context.BMainInstance;
import org.ballerinalang.test.context.LogLeecher;
import org.testng.annotations.Test;

import java.io.File;

/**
 * Test mutual ssl with certificates and keys.
 */
@Test(groups = "http-test")
public class MutualSSLWithCerts extends BaseTest {

    @Test(description = "Test mutual ssl")
    public void testMutualSSLWithCerts() throws Exception {
        String serverResponse = "Response received";
        String privateKey = new File(
                "src" + File.separator + "test" + File.separator + "resources" + File.separator + "certsAndKeys"
                        + File.separator + "private.key").getAbsolutePath();
        String publicCert = new File(
                "src" + File.separator + "test" + File.separator + "resources" + File.separator + "certsAndKeys"
                        + File.separator + "public.crt").getAbsolutePath();

        String balFile = new File(
                "src" + File.separator + "test" + File.separator + "resources" + File.separator + "mutualSSL"
                        + File.separator + "ssl_client.bal").getAbsolutePath();

        String[] flags = { "-e certificate.key=" + privateKey, "-e public.cert=" + publicCert};

        BMainInstance ballerinaClient = new BMainInstance(balServer);
        LogLeecher clientLeecher = new LogLeecher(serverResponse);
        ballerinaClient.runMain(balFile, flags, null, new LogLeecher[]{clientLeecher});
        clientLeecher.waitForText(20000);
    }
}

