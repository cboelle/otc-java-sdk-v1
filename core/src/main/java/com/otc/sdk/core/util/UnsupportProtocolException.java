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

/**
 * Exception thrown when an unsupported protocol is encountered.
 * This exception extends Exception and can be used to indicate that
 * the specified protocol is not recognized or supported.
 */
public class UnsupportProtocolException extends Exception {
  private static final long serialVersionUID = 4312820110480855928L;
  private String msgDes;

  /**
   * Gets the detailed message associated with the exception.
   *
   * @return The detailed message
   */
  public String getMsgDes() {
    return msgDes;
  }

  /**
   * Default constructor for UnsupportProtocolException.
   * Initializes the exception without a specific message.
   */
  public UnsupportProtocolException(String message) {
    super(message);
    msgDes = message;
  }
}
