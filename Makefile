
# Java compiler and flags
JAVAC := javac
JAVA := java
JAVACFLAGS :=

# problem set and problem name as variables
PROBLEM_SET := pset01
PROBLEM_NAME := add

# define the build directory
BUILD_DIR := build

# input and output file paths
INPUT_FILE_TEMPLATE := $(PROBLEM_SET)/$(PROBLEM_NAME)/$(PROBLEM_NAME)$(TEST_NUMBER).in
OUTPUT_FILE_TEMPLATE := $(PROBLEM_SET)/$(PROBLEM_NAME)/$(PROBLEM_NAME)$(TEST_NUMBER).out
RESULT_FILE_TEMPLATE := $(PROBLEM_SET)/$(PROBLEM_NAME)/$(PROBLEM_NAME)$(TEST_NUMBER).res

# source file
SOURCE_FILE := $(PROBLEM_SET)/$(PROBLEM_NAME)/Main.java

# executable path (class files)
EXECUTABLE_DIR := $(BUILD_DIR)/$(PROBLEM_SET)/$(PROBLEM_NAME)
EXECUTABLE := $(EXECUTABLE_DIR)/Main.class

.PHONY: all compile run clean

all: compile run

compile: $(EXECUTABLE)

$(EXECUTABLE): $(SOURCE_FILE)
	@echo "Compiling $<"
	mkdir -p $(EXECUTABLE_DIR)
	$(JAVAC) $(JAVACFLAGS) -d $(EXECUTABLE_DIR) $<

run: $(EXECUTABLE)
	@for i in $(PROBLEM_SET)/$(PROBLEM_NAME)/*.in; do \
		TEST_NUMBER=$${i#*$(PROBLEM_NAME)}; \
		TEST_NUMBER=$${TEST_NUMBER%.in}; \
		INPUT_FILE=$$i; \
		OUTPUT_FILE=$(PROBLEM_SET)/$(PROBLEM_NAME)$${TEST_NUMBER}.out; \
		RESULT_FILE=$(PROBLEM_SET)/$(PROBLEM_NAME)$${TEST_NUMBER}.res; \
		echo "Using input file: $${INPUT_FILE}"; \
		$(JAVA) -cp $(EXECUTABLE_DIR) Main < $${INPUT_FILE} > $${RESULT_FILE}; \
		if [ -e $${OUTPUT_FILE} ]; then \
			diff $${RESULT_FILE} $${OUTPUT_FILE}; \
		fi \
	done

clean:
	@echo "Cleaning up..."
	rm -rf $(BUILD_DIR)/