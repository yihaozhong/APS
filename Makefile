CXX := clang++
CXXFLAGS := -std=c++17 -O2 -Wall -Wextra

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
SOURCE_FILE := $(PROBLEM_SET)/$(PROBLEM_NAME)/main.cpp

# executable path
EXECUTABLE := $(BUILD_DIR)/$(PROBLEM_SET)/$(PROBLEM_NAME)

.PHONY: all compile run clean

all: compile run

compile: $(EXECUTABLE)

$(EXECUTABLE): $(SOURCE_FILE)
	@echo "Compiling $<"
	mkdir -p $(dir $@)
	$(CXX) $(CXXFLAGS) -o $@ $<

run: $(EXECUTABLE)
	@if [ -e $(INPUT_FILE) ]; then \
		echo "Using input file: ${INPUT_FILE}"; \
		$< < $(INPUT_FILE) > $(RESULT_FILE); \
		if [ -e $(OUTPUT_FILE) ]; then \
			diff $(RESULT_FILE) $(OUTPUT_FILE); \
		fi \
	else \
		echo "Using stdin and stdout (no input file detected)"; \
		$<; \
	fi

clean:
	@echo "Cleaning up..."
	rm -rf $(BUILD_DIR)/