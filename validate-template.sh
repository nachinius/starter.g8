#!/bin/bash
# Validation script for the giter8 template
# This script generates a test project from the template and validates it compiles and tests pass

set -e

# Configuration
SCRIPT_DIR="$( cd "$( dirname "${BASH_SOURCE[0]}" )" && pwd )"
TEMPLATE_DIR="${SCRIPT_DIR}"
OUTPUT_DIR="${TEMPLATE_DIR}/target/g8-validation"
PROJECT_NAME="test-validation-project"

echo "=== Giter8 Template Validation Script ==="
echo "Template directory: ${TEMPLATE_DIR}"
echo "Output directory: ${OUTPUT_DIR}"
echo ""

# Clean up previous test runs
if [ -d "${OUTPUT_DIR}" ]; then
    echo "Cleaning up previous test run..."
    rm -rf "${OUTPUT_DIR}"
fi

# Create output directory
mkdir -p "${OUTPUT_DIR}"
cd "${OUTPUT_DIR}"

# Generate project from template
echo "Generating project from template..."
g8 "file://${TEMPLATE_DIR}" \
    --name="${PROJECT_NAME}" \
    --organization="com.test" \
    --force

# Navigate to generated project
cd "${PROJECT_NAME}"

echo ""
echo "=== Validating generated project ==="
echo "Project location: $(pwd)"
echo ""

# Compile the project
echo "Running: sbt compile"
sbt compile

echo ""
echo "=== Running tests ==="
echo "Running: sbt test"
sbt test

echo ""
echo "=== Validation successful! ==="
echo "The template successfully generated a working project."
echo ""
echo "To clean up the test project, run:"
echo "  rm -rf ${OUTPUT_DIR}"
