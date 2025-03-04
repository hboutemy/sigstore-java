/*
 * Copyright 2022 The Sigstore Authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package dev.sigstore.json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.function.Supplier;

/**
 * Supplies a Gson with custom byte to base64 serialization, and no html escaping, this instance of
 * GSON is NOT html/url safe. This should probably be used for any api call to sigstore that expects
 * JSON.
 */
public class GsonSupplier implements Supplier<Gson> {
  @Override
  public Gson get() {
    return new GsonBuilder()
        .registerTypeAdapter(byte[].class, new GsonByteArrayAdapter())
        .disableHtmlEscaping()
        .create();
  }
}
