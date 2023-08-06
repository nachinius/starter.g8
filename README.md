A [Giter8][g8] template for fp in scala 2.13.4

### usage

    sbt new nachinius/starter.g8


### DEV this template: test the template locally
#### By deploying to a subdir and running sbt compile; test

1. clone nachinius/starter/g8
2. point `LOC` where you put it
3. create a test dir
4. call `g8` locally
     
        {
            LOC="/Users/Ignacio/dev/23-g8-scala-fp-starter"
            mkdir -p ~/dev/test-my-g8
            cd ~/dev/test-my-g8; g8 "file://$LOC" --name=g8test --force; cd g8test; sbt 
        }

#### using makefile

	make do
	
and clean up with
	
	make clean


Template license
----------------
Written in 2020 by Ignacio Peixoto 

To the extent possible under law, the author(s) have dedicated all copyright and related
and neighboring rights to this template to the public domain worldwide.
This template is distributed without any warranty. See <http://creativecommons.org/publicdomain/zero/1.0/>.

[g8]: http://www.foundweekends.org/giter8/

