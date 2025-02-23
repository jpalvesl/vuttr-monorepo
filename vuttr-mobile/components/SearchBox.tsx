import { Text, TextInput, View } from 'react-native';

function SearchBox() {
  return (
    <View className="mb-2 h-10 flex-row">
      <TextInput
        className="mr-2 flex flex-1 flex-row rounded-md bg-gray-300 p-2 text-sm text-gray-700"
        placeholder="Busca atividade"
        placeholderTextColor="#6b7280"
      />
      <View className="rounded-md bg-gray-300 p-2 ">
        <Text className=" text-sm text-gray-700">Tag</Text>
      </View>
    </View>
  );
}

export default SearchBox;
