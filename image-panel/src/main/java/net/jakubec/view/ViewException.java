/*
 * Copyright 2018 Michael Jakubec
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

package net.jakubec.view;

import net.jakubec.view.exception.BasicException;

public class ViewException extends BasicException {

	public static int DELETE_FAILED = 1;

	public static int OPEN_FAILED = 2;

	public static final int SAVE_FAILED = 3;

	public ViewException(final int value) {
		super(value);

	}

	public ViewException(Exception e, int value ) {
		super(e, value);

	}

	@Override
	public String getBasicString() {
		return "view.exception";
	}
}
