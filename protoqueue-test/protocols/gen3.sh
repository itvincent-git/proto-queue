#!/bin/bash

bin_path=$(cd $(dirname $0) && pwd -P)

echo "gen_java path : ${bin_path}"

#协议生成路径
gen_path="${bin_path}/../src/main/java"

#描述文件生成路径
desc_path="desc/proto.desc"

if [ ! -d "${gen_path}" ]; then
	mkdir "${gen_path}"
fi

#参数说明
#python python preprocess.py 包名 *.proto
echo "gen_java preprocess start.."
python preprocess.py com.woohoo.app.common.protocol 3 ./files3/
echo "gen_java preprocess end"


protoc_cmd="./protoc"
protoc3_cmd="./protoc3"

echo ""
echo "use [${protoc_cmd}] to generate protocol files......."
echo "gen_path=$gen_path"

if [ ! "${protoc_cmd}" = "" ]; then
	${protoc_cmd} --javanano_out=enum_style=java,optional_field_style=accessors,parcelable_messages=false,java_multiple_files＝false,ignore_services=true:${gen_path} --proto_path="${bin_path}/files3/" ${bin_path}/files3/*.proto
	if [ $? -ne 0 ];then
		echo "failed to create protocol files"
	else
		echo "protocol files was created successful"
		sh ./wrapProtoc/bin/wrapProtoc ${gen_path}/com/woohoo/app/common/protocol/nano/*.java
		${protoc3_cmd} --proto_path="${bin_path}/files3/" ${bin_path}/files3/*.proto  --descriptor_set_out="${desc_path}"
	fi
else
	echo "failed to create protocol files: protoc can not be found!"
fi


