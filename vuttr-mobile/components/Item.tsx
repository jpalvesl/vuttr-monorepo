import Ionicons from '@expo/vector-icons/Ionicons';
import React from 'react';
import { Text, View } from 'react-native';

import Tag from './Tag';

interface Props {
  item: any;
}

function Item({ item }: Props) {
  return (
    <View className="mt-2 rounded-md bg-gray-700 pl-2 pr-2">
      <View className="mb-2 mt-2 flex-row items-center justify-between">
        <Text className="text-4xl text-gray-300">{item.title}</Text>
        <Ionicons name="trash" size={32} color="#d1d5dd" />
      </View>

      <View className="mb-2 flex-row flex-wrap gap-2">
        {item.tags.map((tag) => (
          <Tag key={tag.id} />
        ))}
      </View>
    </View>
  );
}

export default Item;
