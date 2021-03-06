// Copyright (c) 2018 WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
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

package org.ballerinalang.nativeimpl.llvm.gen;

import org.ballerinalang.bre.Context;
import org.ballerinalang.bre.bvm.BlockingNativeCallableUnit;
import org.ballerinalang.model.values.BInteger;
import org.ballerinalang.nativeimpl.llvm.FFIUtil;
import org.ballerinalang.natives.annotations.Argument;
import org.ballerinalang.natives.annotations.BallerinaFunction;
import org.ballerinalang.natives.annotations.ReturnType;
import org.bytedeco.javacpp.LLVM;

import static org.ballerinalang.model.types.TypeKind.INT;
import static org.ballerinalang.model.types.TypeKind.RECORD;
import static org.bytedeco.javacpp.LLVM.LLVMGetSectionContainsSymbol;

/**
 * Auto generated class.
 */
@BallerinaFunction(
        orgName = "ballerina", packageName = "llvm",
        functionName = "LLVMGetSectionContainsSymbol",
        args = {
                @Argument(name = "si", type = RECORD, structType = "LLVMSectionIteratorRef"),
                @Argument(name = "sym", type = RECORD, structType = "LLVMSymbolIteratorRef"),
        },
        returnType = {
                @ReturnType(type = INT, structPackage = "ballerina/llvm"),
        }
)
public class LLVMGetSectionContainsSymbol extends BlockingNativeCallableUnit {

    @Override
    public void execute(Context context) {
        LLVM.LLVMSectionIteratorRef si = FFIUtil.getRecodeArgumentNative(context, 0);
        LLVM.LLVMSymbolIteratorRef sym = FFIUtil.getRecodeArgumentNative(context, 1);
        int returnValue = LLVMGetSectionContainsSymbol(si, sym);
        context.setReturnValues(new BInteger(returnValue));
    }
}
