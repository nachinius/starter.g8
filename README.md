A [Giter8][g8] template for fp in scala 2.13.4

### usage

    sbt new nachinius/starter.g8


### Testing the template

This template includes automated validation to ensure it generates working projects.

#### Quick validation

Run the built-in tests:

    sbt test

This will generate a test project, compile it, and run its tests.

#### Alternative testing methods

See [TESTING.md](TESTING.md) for detailed documentation on all testing methods, including:
- Using the scripted test framework
- Manual validation with the Makefile
- Standalone validation scripts
- Integration with CI/CD

#### Manual testing with Makefile

	make do
	
Clean up with:
	
	make clean


Template license
----------------
Written in 2020 by Ignacio Peixoto 

To the extent possible under law, the author(s) have dedicated all copyright and related
and neighboring rights to this template to the public domain worldwide.
This template is distributed without any warranty. See <http://creativecommons.org/publicdomain/zero/1.0/>.

[g8]: http://www.foundweekends.org/giter8/

