
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
INPUT_FILE := $(PROBLEM_SET)/$(PROBLEM_NAME)/$(PROBLEM_NAME).in
OUTPUT_FILE := $(PROBLEM_SET)/$(PROBLEM_NAME)/$(PROBLEM_NAME).out
RESULT_FILE := $(PROBLEM_SET)/$(PROBLEM_NAME)/$(PROBLEM_NAME).res

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
	@if [ -e $(INPUT_FILE) ]; then \
		echo "Using input file: ${INPUT_FILE}"; \
		$(JAVA) -cp $(EXECUTABLE_DIR) Main < $(INPUT_FILE) > $(RESULT_FILE); \
		if [ -e $(OUTPUT_FILE) ]; then \
			diff $(RESULT_FILE) $(OUTPUT_FILE); \
		fi \
	else \
		echo "Using stdin and stdout (no input file detected)"; \
		$(JAVA) -cp $(EXECUTABLE_DIR) Main; \
	fi

clean:
	@echo "Cleaning up..."
	rm -rf $(BUILD_DIR)/