#!/bin/bash
# SBT-based validation script for the giter8 template
# This script uses sbt's built-in g8 testing functionality

set -e

SCRIPT_DIR="$( cd "$( dirname "${BASH_SOURCE[0]}" )" && pwd )"

echo "=== SBT G8 Template Validation ==="
echo "Template directory: ${SCRIPT_DIR}"
echo ""

cd "${SCRIPT_DIR}"

echo "Running sbt g8Test..."
echo "This will:"
echo "  1. Generate a test project from the template"
echo "  2. Compile the generated project"
echo "  3. Run tests in the generated project"
echo ""

sbt g8Test

echo ""
echo "=== Validation successful! ==="
echo "The template validation passed all checks."
