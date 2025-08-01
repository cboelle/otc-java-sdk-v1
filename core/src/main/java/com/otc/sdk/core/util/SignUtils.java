/*
 * Copyright (c) 2025 T-Systems International GmbH.
 * Licensed under the Apache License, Version 2.0 (the "License");
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

package com.otc.sdk.core.util;

import java.util.HashMap;
import java.util.Map;
import org.apache.http.Header;
import org.apache.http.client.methods.HttpRequestBase;

import com.otc.sdk.core.auth.vo.SignResult;
import com.otc.sdk.service.Client;
import com.otc.sdk.service.Request;

/**
 * SignUtils class provides utility methods for signing requests using a
 * specified
 * algorithm.
 * It includes methods to sign a request and return the signed URL and headers.
 */
public class SignUtils {
  private static final String SDKSIGNINGSHA256 = "SDK-HMAC-SHA256";

  /**
   * Signs a request using the specified algorithm and returns the signed URL and
   * headers.
   *
   * @param request   The request to be signed
   * @param algorithm The signing algorithm to use (default is "SDK-HMAC-SHA256")
   * @return SignResult containing the signed URL and headers
   * @throws Exception if an error occurs during signing
   */
  public static SignResult sign(Request request, String algorithm) throws Exception {
    SignResult result = new SignResult();
    HttpRequestBase signedRequest = Client.sign(request, algorithm);
    Header[] headers = signedRequest.getAllHeaders();
    Map<String, String> headerMap = new HashMap<>();
    Header[] var6 = headers;
    int var7 = headers.length;

    for (int var8 = 0; var8 < var7; ++var8) {
      Header header = var6[var8];
      headerMap.put(header.getName(), header.getValue());
    }

    result.setUrl(signedRequest.getURI().toURL());
    result.setHeaders(headerMap);
    return result;
  }

  /**
   * Signs a request using the default signing algorithm "SDK-HMAC-SHA256" and
   * returns the signed URL and headers.
   *
   * @param request The request to be signed
   * @return SignResult containing the signed URL and headers
   * @throws Exception if an error occurs during signing
   */
  public static SignResult sign(Request request) throws Exception {
    return sign(request, SDKSIGNINGSHA256);
  }
}
