package com.qa.utility;

public enum EnumPageClass {

	INDEX {
		@Override
		public String toString() {
			return "index";

		}
	},

	VALUE {
		@Override
		public String toString() {
			return "value";

		}
	},

	VISIBLETEXT {

		@Override
		public String toString() {
			return "visibletext";

		}
	}

}
