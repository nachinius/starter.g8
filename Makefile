mkfile_path := $(abspath $(lastword $(MAKEFILE_LIST)))
current_dir := $(notdir $(patsubst %/,%,$(dir $(mkfile_path))))
this_dir = $(dir $(mkfile_path))

OUTPUT := test-my-g8

.ONESHELL:
do:
	mkdir -p $(this_dir)/$(OUTPUT)
	cd $(this_dir)/$(OUTPUT)
	g8 file://$(this_dir) --name=g8test --force
	cd g8test
	sbt "compile; test"

clean:
	rm -r $(this_dir)/$(OUTPUT)

