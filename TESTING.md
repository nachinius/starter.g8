# Template Validation

This directory contains scripts and tests to validate that the giter8 template works correctly.

## Testing Methods

There are three ways to test the template:

### 1. SBT G8 Test (Recommended)

The template includes built-in testing using sbt's giter8 plugin and scripted test framework.

```bash
sbt test
```

This command will:
1. Generate a test project from the template
2. Compile the generated project
3. Run tests in the generated project

The test script is located in `src/test/g8/test`.

### 2. Scripted Test Framework

You can also run the scripted tests directly:

```bash
sbt scripted
```

This uses sbt's scripted test framework and will execute the same validation.

### 3. Manual Validation with Makefile

The existing Makefile provides a manual way to test:

```bash
make do
```

This will:
1. Create a `test-my-g8` directory
2. Generate a project from the template
3. Compile and test the generated project

Clean up with:

```bash
make clean
```

### 4. Standalone Validation Scripts

Two standalone scripts are provided for convenience:

#### validate-template-sbt.sh
Uses sbt's built-in g8Test functionality:

```bash
./validate-template-sbt.sh
```

#### validate-template.sh
Uses the g8 command-line tool (requires g8 to be installed):

```bash
./validate-template.sh
```

## What Gets Tested

The validation process ensures that:

1. **Template Generation**: The giter8 template can successfully generate a new project
2. **Compilation**: The generated project compiles without errors
3. **Tests Pass**: The generated project's tests pass successfully

## Generated Test Files

The template includes test files that will be part of any generated project:

- `src/test/scala/$package$/MainSpec.scala` - Tests for the Main object
- `src/test/scala/$package$/ServerSpec.scala` - Tests for the Server and HTTP routes

These tests use the munit testing framework which is included in the template's dependencies.

## Integration with CI/CD

To integrate this validation into a CI/CD pipeline (like GitHub Actions), you can use:

```yaml
- name: Validate template
  run: sbt test
```

Or for more verbose output:

```yaml
- name: Validate template  
  run: sbt scripted
```

## Troubleshooting

If tests fail due to dependency resolution issues, ensure that:
1. You have internet connectivity
2. Maven Central and other repositories are accessible
3. Your sbt version matches the one specified in `project/build.properties`

## Structure

- `src/test/g8/test` - Scripted test script that defines what commands to run
- `src/main/g8/src/test/scala/` - Test files included in the generated template
- `validate-template.sh` - Standalone validation script using g8
- `validate-template-sbt.sh` - Standalone validation script using sbt
- `Makefile` - Manual testing targets
